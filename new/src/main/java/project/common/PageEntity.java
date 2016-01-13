package project.common;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 */
@Entity
public class PageEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** ==========================================输入================================================= **/
    /**
     * 表名
     */
    private String table;
    /**
     * 当前页数
     */
    private Integer pageNow;
    /**
     * 开始条数
     */
    private Integer startRow;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 条件
     */
    private String where;
    /**
     * 排序字段
     */
    private String orderColumn;
    /**
     * 排序方式
     */
    private String orderStyle;
    /** ==========================================输入================================================= **/

    /** ==========================================输出================================================= **/
    /**
     * 总条数
     */
    private Integer totalRows;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     *
     */
    private List<T> receList;

    /**
     * ==========================================输出=================================================
     **/

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderStyle() {
        return orderStyle;
    }

    public void setOrderStyle(String orderStyle) {
        this.orderStyle = orderStyle;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getReceList() {
        return receList;
    }

    public void setReceList(List<T> receList) {
        this.receList = receList;
    }

}
