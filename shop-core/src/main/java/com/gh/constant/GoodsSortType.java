package com.gh.constant;



/**
 * @author finally
 */

public enum GoodsSortType {

    isTop("is_top.desc", "置顶降序"),
    priceasc("price.asc", "价格升序"),
    pricedesc("price.desc", "价格降序"),
    sales("sales.desc", "销量降序"),
    score("score.desc", "评分降序"),
    create_date("create_date.desc", "日期降序");

    private String sortType;
    private String showType;

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }



    private GoodsSortType(){

    }

    private GoodsSortType(String sortType,String showType){
        this.sortType = sortType;
        this.showType = showType;
    }


    /**
     * 根据sort获取枚举对象
     * @param sortType
     * @return
     */
    public static String findShowType(String sortType){

        for (GoodsSortType orderType : GoodsSortType.values()) {
            if (orderType.getSortType().equals(sortType)) {
                return orderType.getSortType();
            }
        }
        return null;
    }

}
