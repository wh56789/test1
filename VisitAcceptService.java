package com.onlinepowers.ubase.visitaccept.service;

import java.util.List;
import java.util.Map;

import com.onlinepowers.ubase.visitaccept.model.comboBox.ComboBox;
import com.onlinepowers.ubase.visitaccept.model.domain.RRepairMaster;
import com.onlinepowers.ubase.visitaccept.model.domain.VisitAccept;

public interface VisitAcceptService {
	// noReceipt max+1 값 받아오기
	public String getNoReceipt(VisitAccept visitAccept);
	
	// visitAccept 등록
	public void insertVisitAccept(Map map);
	
	// visitAccept 파일 정보 update
	public void updateVisitAcceptFile(Map map);
	
	// visitAccept 가져오기
	public VisitAccept getVisitAccept(VisitAccept visitAccept);
	
	// repair pdf 등록 후 정보 update
	public void updateProcess(Map Map);
	
	// 번호표 중복 체크 
	public int noSeqDuplicated(VisitAccept visitAccept);
	
	// 담당자 지정
	public void setUser(VisitAccept visitAccept);
	
	//콤보 박스
	public List comboBoxSelect(String cdMaster);
	public List comboBoxSelectValue(Map map) ;
	public List issueCommboBox(Map map) ;
	
	// RRepairMaster 가져오기
	public List getRRepairMaster(RRepairMaster rRepairMaster);
	
	public Map getPriseList(Map map) ; // 수리 부품 리스트
//	public Map getPriceSum(Map map) ; // 합계 가격
//	public Map getPaySum(Map map) ; // 카드 현금 가격
	
	// 견적 확인서 디스플레이, 본체 단가 가져오기
	public Map selectCdEee(Map map) ; // 디스플레이, 본체 단가 가져오기

	
	public Map selectRenParam(Map map) ;
	
}
