test update222
test update


package com.onlinepowers.ubase.visitaccept.service;

import java.util.List;
import java.util.Map;

import com.onlinepowers.ubase.visitaccept.model.comboBox.ComboBox;
import com.onlinepowers.ubase.visitaccept.model.domain.RRepairMaster;
import com.onlinepowers.ubase.visitaccept.model.domain.VisitAccept;

public interface VisitAcceptService {
	// noReceipt max+1 �?받아?�기
	public String getNoReceipt(VisitAccept visitAccept);
	
	// visitAccept ?�록
	public void insertVisitAccept(Map map);
	
	// visitAccept ?�일 ?�보 update
	public void updateVisitAcceptFile(Map map);
	
	// visitAccept 가?�오�?
	public VisitAccept getVisitAccept(VisitAccept visitAccept);
	
	// repair pdf ?�록 ???�보 update
	public void updateProcess(Map Map);
	
	// 번호??중복 체크 
	public int noSeqDuplicated(VisitAccept visitAccept);
	
	// ?�당??지??
	public void setUser(VisitAccept visitAccept);
	
	//콤보 박스
	public List comboBoxSelect(String cdMaster);
	public List comboBoxSelectValue(Map map) ;
	public List issueCommboBox(Map map) ;
	
	// RRepairMaster 가?�오�?
	public List getRRepairMaster(RRepairMaster rRepairMaster);
	
	public Map getPriseList(Map map) ; // ?�리 부??리스??
//	public Map getPriceSum(Map map) ; // ?�계 가�?
//	public Map getPaySum(Map map) ; // 카드 ?�금 가�?
	
	// 견적 ?�인???�스?�레?? 본체 ?��? 가?�오�?
	public Map selectCdEee(Map map) ; // ?�스?�레?? 본체 ?��? 가?�오�?

	
	public Map selectRenParam(Map map) ;
	
}
