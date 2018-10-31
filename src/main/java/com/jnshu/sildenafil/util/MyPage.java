package com.jnshu.sildenafil.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**实现了mybatis plus的Ipage接口;
 * 功能：增加了上一页,下一页,总页数和toString(全部内容输出)
 * 使用:使用方法同原生page,new的时候新建myPage
 * @author feifei
 */
public class MyPage<T> implements IPage<T> {
    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();
    /**
     * 总数，当 total 不为 0 时分页插件不会进行 count 查询
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 总页数，默认 0
     * 手动添加 by feifei
     */
    private long pages = 0;

    /**
     * 当前页
     */
    private long current = 1;
    /**
     * 上一页
     * 手动添加 by feifei
     */
    private long previous  =0;
    /**
     * 下一页
     * 手动添加 by feifei
     */
    private long next =2;
    /**
     * <p>
     * SQL 排序 ASC 数组
     * </p>
     */
    private String[] ascs;
    /**
     * <p>
     * SQL 排序 DESC 数组
     * </p>
     */
    private String[] descs;
    /**
     * <p>
     * 自动优化 COUNT SQL
     * </p>
     */
    private boolean optimizeCountSql = true;

    public MyPage() {
        // to do nothing
    }

    /**
     * <p>
     * 分页构造函数
     * </p>
     *
     * @param current 当前页
     * @param size    每页显示条数
     */
    public MyPage(long current, long size) {
        this(current, size, 0);
    }

    public MyPage(long current, long size, long total) {
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.total = total;

    }

    /**
     * <p>
     * 是否存在上一页
     * </p>
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.current > 1;
    }

    /**
     * <p>
     * 是否存在下一页
     * </p>
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.current < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public MyPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public MyPage<T> setTotal(long total) {
        this.total = total;
        //在此处设置pages,previous,next结果---by feifei
        this.pages=this.getPages();
        this.previous= this.current >= 1 ? this.current - 1 : 1;
        this.next= this.current< this.pages ? this.current + 1 : pages;
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public MyPage<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public MyPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    public long getPrevious() {
        return this.previous= this.current >= 1 ? this.current - 1 : 0;
    }

    public long getNext() {
        return this.next= this.current<= this.pages ? this.current + 1 : pages;
    }


    @Override
    public String[] ascs() {
        return ascs;
    }

    public MyPage<T> setAscs(List<String> ascs) {
        if (CollectionUtils.isNotEmpty(ascs)) {
            this.ascs = ascs.toArray(new String[0]);
        }
        return this;
    }


    /**
     * <p>
     * 升序
     * </p>
     *
     * @param ascs 多个升序字段
     */
    public MyPage<T> setAsc(String... ascs) {
        this.ascs = ascs;
        return this;
    }

    @Override
    public String[] descs() {
        return descs;
    }

    public MyPage<T> setDescs(List<String> descs) {
        if (CollectionUtils.isNotEmpty(descs)) {
            this.descs = descs.toArray(new String[0]);
        }
        return this;
    }

    /**
     * <p>
     * 降序
     * </p>
     *
     * @param descs 多个降序字段
     */
    public MyPage<T> setDesc(String... descs) {
        this.descs = descs;
        return this;
    }

    @Override
    public boolean optimizeCountSql() {
        return optimizeCountSql;
    }

    public MyPage<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }


    @Override
    public String toString() {
        return "MyPage{" +
                "records=" + records +
                ", total=" + total +
                ", size=" + size +
                ", pages=" + pages +
                ", current=" + current +
                ", previous=" + previous +
                ", next=" + next +
                ", ascs=" + Arrays.toString(ascs) +
                ", descs=" + Arrays.toString(descs) +
                ", optimizeCountSql=" + optimizeCountSql +
                '}';
    }
}
