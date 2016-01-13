package sample.test.alo;

public class PageDefine {

    /**
     * 字段名称：PAGE_SIZE
     * 字段类型: int
     * 字段描述：每页显示的记录数
     */
    static final int PAGE_SIZE = 10;
    /**
     * 字段名称：PAGE_NUM
     * 字段类型: int
     * 字段描述：页码
     */
    static final int PAGE_NUM = 1;
    /**
     * 字段名称：PAGE_COUNT
     * 字段类型: int
     * 字段描述：总页数
     */
    static final int PAGE_COUNT = 0;
    /**
     * 字段名称：RECORD_COUNT
     * 字段类型: int
     * 字段描述：总记录数
     */
    static final int RECORD_COUNT = 0;
    /**
     * 字段名称：BEGIN_RECORD
     * 字段类型: int
     * 字段描述：起始记录序号
     */
    static final int BEGIN_RECORD = 0;
    /**
     * 字段名称：DB_NAME
     * 字段类型: int
     * 字段描述：数据库名,默认是MYSQL
     */
    static final DBName DB_NAME = DBName.MYSQL;
    /**
     * 字段名称：PAGE_BEAN_NAME
     * 字段类型: int
     * 字段描述：分页应用时pageBean变量的名称
     */
    static final String PAGE_BEAN_NAME = "pageBean";
}
