package ar.com.uala.movies.models;

public class Notification {
	
	private Type type;
	private Boolean active;
	
	public Notification(Type type, Boolean active) {
		super();
		this.type = type;
		this.active = active;
	}


	public enum Type {
		SMS {
			@Override
			public String toString() {
				return "sms";
			}
		},
		PHONE {
			@Override
			public String toString() {
				return "phone";
			}
		},
		EMAIL {
			@Override
			public String toString() {
				return "email";
			}
		}
	}
	
	
	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}



}
