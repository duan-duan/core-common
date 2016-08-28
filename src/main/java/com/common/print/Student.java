/**
 * 
 */
package com.common.print;

import com.common.entity.BaseSerializable;

/**
 * @author huanggaoren
 *
 */
public class Student implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5694109755906171912L;

	private String su_account;

	private String su_name;

	private Boolean sex;

	private String su_email;

	public String getSu_account() {
		return su_account;
	}

	public void setSu_account(String su_account) {
		this.su_account = su_account;
	}

	public String getSu_name() {
		return su_name;
	}

	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getSu_email() {
		return su_email;
	}

	public void setSu_email(String su_email) {
		this.su_email = su_email;
	}

	public Student(String su_account, String su_name, Boolean sex,
			String su_email) {
		super();
		this.su_account = su_account;
		this.su_name = su_name;
		this.sex = sex;
		this.su_email = su_email;
	}

}
