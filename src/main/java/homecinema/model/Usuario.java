package homecinema.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Usuario {
	@Id public Long id_user;
	private String nickname;
	private String email;
	private String password;

	public Usuario(){}
	
	@JsonCreator
	public Usuario(@JsonProperty("nickname") String nickname, @JsonProperty("email") String email, @JsonProperty("password") String password) {
		this.nickname = nickname;
		if(email == null){
			this.email = "email";
		}else{
			this.email = email;
		}
		this.password = password;
	}

	/*public Usuario(String nickname, String email, String password) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
	}*/

	public Long getId_user() {
		return id_user;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
