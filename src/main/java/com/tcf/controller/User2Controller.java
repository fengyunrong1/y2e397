package com.tcf.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tcf.entity.SmbmsRole;
import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsRoleService;
import com.tcf.service.SmbmsUserService;


@Controller
@RequestMapping("user")
public class User2Controller {
	
	@Autowired
	private SmbmsUserService us;
	@Autowired
	private SmbmsRoleService rs;
	
	@RequestMapping("adduser.do")
	public String addUser(@ModelAttribute("user") SmbmsUser user,HttpSession session){
		session.setAttribute("roles", changeMap(rs.getAllSmbmsRoles()));
		return "adduser";
	}
	/*@RequestMapping("saveuser.do")
	public String saveUser(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult result){
		if(us.addSmbmsUser(user)>0){
			return "redirect:userList.do";
		}
		return "adduser";
	}*/
	/*@RequestMapping("saveuser.do")
	public String saveUser(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult result,MultipartFile photo,HttpSession session){
		//上传图片
		String error = checkFile(photo);
		if(error != null){
			result.addError(new ObjectError("photoPath", error));
		}else{
			//上传
			String path = session.getServletContext().getRealPath("photos");
			//12341243214321432142421432abc.jpg
			String filename = System.currentTimeMillis()+photo.getOriginalFilename();
			File dest = new File(path,filename);
			try {
				photo.transferTo(dest);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//保存
			user.setPhotoPath("photos"+File.separator+filename);
			if(us.addSmbmsUser(user)>0){
				return "redirect:userList.do";
			}
		}
		return "adduser";
	}*/
	@RequestMapping("saveuser.do")
	public String saveUser(@ModelAttribute("user") @Valid SmbmsUser user,BindingResult result,@RequestParam("photos") MultipartFile[] photos,HttpSession session,Model model){
		String path = session.getServletContext().getRealPath("photos");
		System.out.println("fileUpload:=============================================");
		List<String> errors = new ArrayList<String>();
		List<String> filenames = new ArrayList<String>();
		//上传图片
		for(MultipartFile photo:photos){
			String error = checkFile(photo);
			errors.add(error);
			if(error == null)
				filenames.add(upload(photo, path));
		}
		if(filenames.size() > 0){
			//保存
			user.setPhotoPath("photos"+File.separator+filenames.get(0));
			if(us.addSmbmsUser(user)>0){
				return "redirect:userList.do";
			}
		}
		model.addAttribute("errors", errors);
		return "adduser";
	}
	/**
	 * 
	 * @param photo
	 * @param path
	 * @return  文件名，null代表上传失败
	 */
	public String upload(MultipartFile photo,String path){
		String filename = System.currentTimeMillis()+photo.getOriginalFilename();
		File dest = new File(path,filename);
		try {
			photo.transferTo(dest);
			return filename;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static List<String> formats = new ArrayList<String>();
	static{
		formats.add("jpg");
		formats.add("png");
		formats.add("jpeg");
		formats.add("pneg");
	}
	/**
	 * 	//1.是否为Null
		//2.大小的限制
		//3.格式的限制
	 * @param photo
	 * @return null is ok.
	 */
	public String checkFile(MultipartFile photo){
		String fileName = photo.getOriginalFilename();
		String sufName = FilenameUtils.getExtension(fileName);
		if(photo.isEmpty()){
			return String.format("%s:文件不能为null", fileName);
		}else{
			if(photo.getSize()>5000000){
				return String.format("%s:文件大小不能超过500kB", fileName);
			}else if(!formats.contains(sufName.toLowerCase())){
				return String.format("%s:上传的图片格式不正确", fileName);
			}
		}
		return null;
	}
	
	/*@RequestMapping("modifyUser.do")
	public String modifyUser(Long id,Map<String,Object> map){
		map.put("user", us.getUserById(id));
		return "usermodify";
	}*/
	@RequestMapping("/modifyUser/{id}")///modifyUser/12
	public String modifyUser(@PathVariable("id") Long id,Map<String,Object> map){
		map.put("user", us.getUserById(id));
		return "usermodify";
	}
	@RequestMapping("updateuser.do")
	public String updateUser(@ModelAttribute("user") SmbmsUser user){
		if(us.updateSmbmsUser(user)>0){
			return "redirect:userList.do";
		}
		return "usermodify";
	}
	
	public Map<Long,String> changeMap(List<SmbmsRole> roles){
		Map<Long,String> map = new HashMap<Long, String>();
		for(SmbmsRole role:roles){
			map.put(role.getId(), role.getRoleName());
		}
		return map;
	}
}
