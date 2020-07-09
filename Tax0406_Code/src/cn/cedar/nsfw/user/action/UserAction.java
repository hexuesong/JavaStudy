package cn.cedar.nsfw.user.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.cedar.nsfw.user.entity.User;
import cn.cedar.nsfw.user.service.UserService;

public class UserAction extends ActionSupport {

	@Resource
	private UserService userService;
	private List<User> userList;
	private User user;
	private String[] selectedRow;
	private File headImg;
	private String headImgContentType;
	private String headImgFileName;

	// �б�ҳ��
	public String listUI() {
		userList = userService.findObjects();
		return "listUI";
	}

	// ��ת������ҳ��
	public String addUI() {
		return "addUI";
	}

	// ��������
	public String add() {
		try {
			if (user != null) {
				// ����ͷ��
				if (headImg != null) {
					// 1.���浽upload/user
					// ��ȡ����·���ľ��Ե�ַ
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString().replace("-", "")
							+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
					// �����ļ�
					FileUtils.copyFile(headImg, new File(filePath, fileName));
					// 2.�����û�ͷ��·��
					user.setHeadImg("user/" + fileName);//user/123.jpg
				}
				userService.save(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "list";
	}

	// ��ת���༭ҳ��
	public String editUI() {
		if (user != null && user.getId() != null) {
			user = userService.findByObjectById(user.getId());
		}
		return "editUI";
	}

	// ����༭
	public String edit() {
		try {
			if (user != null) {
				// ����ͷ��
				if (headImg != null) {
					// 1.���浽upload/user
					// ��ȡ����·���ľ��Ե�ַ
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString().replace("-", "")
							+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
					// �����ļ�
					FileUtils.copyFile(headImg, new File(filePath, fileName));
					// 2.�����û�ͷ��·��
					user.setHeadImg("user/" + fileName);//user/123.jpg
				}
				userService.update(user);
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "edit";
	}

	// ɾ��
	public String delete() {
		if (user != null && user.getId() != null) {
			userService.delete(user.getId());
		}
		return "list";
	}

	// ����ɾ��
	public String deleteSelected() {
		if (selectedRow != null) {
			for (String id : selectedRow) {
				userService.delete(id);
			}
		}
		return "list";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

}
