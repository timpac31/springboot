package com.demo.board.domain;

public class PageVO {
	private int listSize = 10;	//목록 사이즈
	private int pageSize = 10;	//페이지 블록 사이즈
	private int totalSize;		//게시글 수
	private int pageNo = 1;		//현재페이지 번호	
	private int startNo;		//시작 페이지 번호
	private int endNo;			//끝 페이지 번호
	private int totalPageNo;	//총 페이지 수
	private boolean hasNextPage;	//다음 페이지 여부
	private int startRow;		//쿼리 시작 로우넘버
	private int endRow;			//쿼리 끝 로우넘버
	
	private String searchType;	//for search
	private String keyword;
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getTotalPageNo() {
		return totalPageNo;
	}
	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * 게시글 총 갯수를 받아 페이지를 셋팅한다 
	 * @param totalSize	
	 */
	public void setPage(int totalSize) {
		setTotalSize(totalSize);
		
		startNo = ((pageNo-1) / pageSize) * pageSize + 1;
		endNo = startNo + pageSize - 1;
		totalPageNo = totalSize / listSize;
		if(totalSize % listSize > 0) totalPageNo++;

		if(endNo > totalPageNo){
			endNo = totalPageNo;
			hasNextPage = false;
		}
		
		startRow = (pageNo-1) * listSize + 1;
		endRow = pageNo * listSize;
	}

}


