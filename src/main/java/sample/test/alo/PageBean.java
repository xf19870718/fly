package sample.test.alo;

public class PageBean {

    private int beginRecord = PageDefine.BEGIN_RECORD;
    private int pageSize = PageDefine.PAGE_SIZE;
    private int pageNum = PageDefine.PAGE_NUM;
    private int pageCount = PageDefine.PAGE_COUNT;
    private int recordCount = PageDefine.RECORD_COUNT;

    public int getBeginRecord() {
        return beginRecord;
    }

    public void setBeginRecord(int beginRecord) {
        this.beginRecord = beginRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }
}
