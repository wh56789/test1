test update222
test update


package com.onlinepowers.ubase.visitaccept.service;

import java.util.List;
import java.util.Map;

import com.onlinepowers.ubase.visitaccept.model.comboBox.ComboBox;
import com.onlinepowers.ubase.visitaccept.model.domain.RRepairMaster;
import com.onlinepowers.ubase.visitaccept.model.domain.VisitAccept;

public interface VisitAcceptService {
	// noReceipt max+1 ê°?ë°›ì•„?¤ê¸°
	public String getNoReceipt(VisitAccept visitAccept);
	
	// visitAccept ?±ë¡
	public void insertVisitAccept(Map map);
	
	// visitAccept ?Œì¼ ?•ë³´ update
	public void updateVisitAcceptFile(Map map);
	
	// visitAccept ê°€?¸ì˜¤ê¸?
	public VisitAccept getVisitAccept(VisitAccept visitAccept);
	
	// repair pdf ?±ë¡ ???•ë³´ update
	public void updateProcess(Map Map);
	
	// ë²ˆí˜¸??ì¤‘ë³µ ì²´í¬ 
	public int noSeqDuplicated(VisitAccept visitAccept);
	
	// ?´ë‹¹??ì§€??
	public void setUser(VisitAccept visitAccept);
	
	//ì½¤ë³´ ë°•ìŠ¤
	public List comboBoxSelect(String cdMaster);
	public List comboBoxSelectValue(Map map) ;
	public List issueCommboBox(Map map) ;
	
	// RRepairMaster ê°€?¸ì˜¤ê¸?
	public List getRRepairMaster(RRepairMaster rRepairMaster);
	
	public Map getPriseList(Map map) ; // ?˜ë¦¬ ë¶€??ë¦¬ìŠ¤??
//	public Map getPriceSum(Map map) ; // ?©ê³„ ê°€ê²?
//	public Map getPaySum(Map map) ; // ì¹´ë“œ ?„ê¸ˆ ê°€ê²?
	
	// ê²¬ì  ?•ì¸???”ìŠ¤?Œë ˆ?? ë³¸ì²´ ?¨ê? ê°€?¸ì˜¤ê¸?
	public Map selectCdEee(Map map) ; // ?”ìŠ¤?Œë ˆ?? ë³¸ì²´ ?¨ê? ê°€?¸ì˜¤ê¸?

	
	public Map selectRenParam(Map map) ;
	
}
