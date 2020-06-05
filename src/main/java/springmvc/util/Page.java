package springmvc.util;

public class Page {

    int start;//开始的数据
    int count;//每一页的数据量
    int total;//总共的数据量

    public Page(int start, int count){
        super();
        this.start = start;
        this.count = count;

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    //最后一页的开头编号
    public int getLast(){
        int last;

        if (total % count == 0)
            last = total - count + 1;
        else
            last =total - total % count + 1;

//        last = last<0?0:last;
        return last;
    }

    //分页
    public int getTotalPage(){
        int totalPage;

        if (total % count == 0)
            totalPage = total % count;
        else
            totalPage = total % count + 1;

        if (totalPage == 0)
            totalPage = 1;

        return totalPage;
    }

    public boolean isHasPrevious(){
        if (start == 0)
            return false;
        return true;
    }

    public boolean isHasNext(){
        if (start == getLast())
            return false;
        return true;
    }
}
