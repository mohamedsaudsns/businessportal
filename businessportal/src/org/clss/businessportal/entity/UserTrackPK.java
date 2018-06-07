package org.clss.businessportal.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_track database table.
 * 
 */
@Embeddable
public class UserTrackPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SESSION_ID")
	private String sessionId;

	@Column(name="USER_ID")
	private String userId;

	public UserTrackPK() {
	}
	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserTrackPK)) {
			return false;
		}
		UserTrackPK castOther = (UserTrackPK)other;
		return 
			this.sessionId.equals(castOther.sessionId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.sessionId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}