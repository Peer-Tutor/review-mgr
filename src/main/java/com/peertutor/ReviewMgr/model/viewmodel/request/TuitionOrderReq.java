package com.peertutor.ReviewMgr.model.viewmodel.request;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class TuitionOrderReq {
	@NotNull
    @NotEmpty
    public Long tutorId;
    
    @NotNull
    @NotEmpty
    public Long tutorOrderId;
    
    public Long getTutorId() {
		return tutorId;
	}

	public void setTutorId(Long tutorId) {
		this.tutorId = tutorId;
	}

	public Long getTutorOrderId() {
		return tutorOrderId;
	}

	public void setTutorOrderId(Long tutorOrderId) {
		this.tutorOrderId = tutorOrderId;
	}
    
//    public TuitionOrderReq(Long tutorId, Long tutorOrderId) {
//        this.tutorId = tutorId;
//        this.tutorOrderId = tutorOrderId;
//    }

}
