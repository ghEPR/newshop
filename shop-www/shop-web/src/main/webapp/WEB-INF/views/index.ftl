<!DOCTYPE html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>首页</title>
    <link href="${ctx}/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="${ctx}/slider/slider.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.tools.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.lazyload.js"></script>
    <script type="text/javascript" src="${ctx}/slider/slider.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <style type="text/css">
        .header {
            margin-bottom: 0px;
        }
    </style>
    <script type="text/javascript">
        $().ready(function() {

            var $productCategoryMenuItem = $("#productCategoryMenu li");
            var $slider = $("#slider");
            var $newArticleTab = $("#newArticle ul.tab");
            var $hotGoodsImage = $("div.hotGoods img");

            $productCategoryMenuItem.hover(
                    function() {
                        $(this).children("div.menu").show();
                    }, function() {
                        $(this).children("div.menu").hide();
                    }
            );

            $slider.nivoSlider({
                effect: "random",
                animSpeed: 1000,
                pauseTime: 6000,
                controlNav: true,
                keyboardNav: false,
                captionOpacity: 0.4
            });

            $newArticleTab.tabs("ul.tabContent", {
                tabs: "li",
                event: "mouseover"
            });

            $hotGoodsImage.lazyload({
                threshold: 100,
                effect: "fadeIn",
                skip_invisible: false
            });

        });
    </script>
</head>
<body>

    [#include "include/header.ftl"]

<div class="container index">
    <div class="row">
        <div class="span2">
            <div id="productCategoryMenu" class="productCategoryMenu">
                <ul>

                    [#--根级分类展示--]
                    [@productCategoryRootListDirective]
                    <li>
                        <div class="item">

                            [#--子级分类展示--]
                                <div>
                                    [@product_category_children_list parentId=productCategory.id]
                                        [#list productCategories as productCategorie]
                                            <a href="${ctx}/goods/list/${productCategorie.id}">
                                                <strong>${productCategorie.name}</strong>
                                            </a>
                                        [/#list]
                                    [/@product_category_children_list]
                                </div>
                                [#--根级分类的品牌展示--]
                                <div>
                                    [@brand_list productCategoryId = productCategory.id]
                                        [#list brands as brand]
                                            <a href="${ctx}/brand/${brand.id}">${brand.name}</a>
                                        [/#list]
                                    [/@brand_list]
                                </div>
                        </div>

                        [#--鼠标放上去弹出--]
                        <div class="menu">
                            [@product_category_children_list parentId=productCategory.id count=10]
                                [#list productCategories as productCategorie]
                                <dl class="clearfix last">
                                    <dt>
                                        <a href="${ctx}/goods/list/${productCategorie.id}">${productCategorie.name}</a>
                                    </dt>
                                    [@product_category_children_list parentId=productCategory.id count=10]
                                        [#list productCategories as productCategorie]
                                            <dd>
                                                <a href="${ctx}/goods/list/${productCategorie.id}">${productCategorie.name}</a>
                                                [#if productCategorie_has_next]|[/#if]
                                            </dd>
                                        [/#list]
                                    [/@product_category_children_list]
                                </dl>
                                [/#list]
                            [/@product_category_children_list]

                            <div class="auxiliary">
                                <div>
                                    [@brand_list productCategoryId = productCategory.id limit = 10]
                                        [#if brands?has_content]
                                            <strong>推荐品牌</strong>
                                            [#list brands as brand]
                                                <a href="${ctx}/brand/${brand.id}">${brand.name}</a>
                                            [/#list]
                                        [/#if]
                                    [/@brand_list]
                                </div>
                                <div>
                                    [@promotion_list productCagetoryId = productCategory.id]
                                        [#if promotions?has_content]
                                            <strong>热门促销</strong>
                                            [#list promotions as promotion]
                                            <a href="${ctx}/promotion/${promotion.id}" title="${promotion.name}">
                                                <img src="${promotion.image}" alt="${promotion.name}" />
                                            </a>
                                            [/#list]
                                        [/#if]
                                    [/@promotion_list]
                                </div>
                            </div>
                        </div>
                    </li>
                    [/@productCategoryRootListDirective]
                </ul>
            </div>
        </div>
        <div class="span10">
            [#--轮播广告--]
            [@ad_position id = 1 /]
        </div>
    </div>
    [#--第二栏--]
    <div class="row">
        [#--热点广告--]
        <div class="span9">
            [@ad_position id = 2 /]
        </div>

        [#--文章分类--]
        <div class="span3">
            <div id="newArticle" class="newArticle">
                <ul class="tab">
                    [@article_category_root_list]
                        [#list articleCategories as articleCategorie]
                            <li>
                                <a href="${ctx}/article_category/${articleCategorie.id}" target="_blank">
                                    ${articleCategorie.name}
                                </a>
                            </li>
                        [/#list]
                    [/@article_category_root_list]
                </ul>
                    [@article_category_root_list ]
                        [#list articleCategories as articleCategorie]
                            <ul class="tabContent">
                                [@article_list categoryId = articleCategorie.id limit = 6]
                                    [#list articles as article]
                                        <li>
                                            <a href="${ctx}/article/${article.id}" title="${article.title}" target="_blank">
                                                ${article.title}
                                            </a>
                                        </li>
                                    [/#list]
                                [/@article_list]
                            </ul>
                        [/#list]
                    [/@article_category_root_list ]
            </div>
        </div>
    </div>

    [#--中间广告位--]
    <div class="row">
        <div class="span12">
            [@ad_position id = 3 /]
        </div>
    </div>

    [#--热门商品分类展示--]
    [#assign ads = null ]
    [@ad_list positionId = 4]
        [#assign ads = ads ]
    [/@ad_list]

    [@product_category_root_list limit = 3]
        [#list productCategories as productCategorie]
            <div class="row">
                <div class="span12">
                    <div class="hotGoods">
                        <dl class="title1">
                            <dt>
                                <a href="${ctx}/goods/list/${productCategorie.id}">${productCategorie.name}</a>
                            </dt>
                            [@product_category_children_list parentId = productCategorie.id limit = 100]
                                [#list productCategories as productCategorie]
                                    <dd>
                                        <a href="${ctx}/goods/list/${productCategorie.id}">${productCategorie.name}</a>
                                    </dd>
                                [/#list]
                            [/@product_category_children_list]
                        </dl>
                        <div>
                            [#assign ad = ads[productCategory_index]]
                            <a href="#">
                                <img src="ad.path" alt="ad.title" title="ad.title">
                            </a>
                        </div>
                        <ul>
                            [@goods_list categoryId = productCategorie.id tagId = 3]
                                [#list goods as good]
                                    [#if good_index < 5]
                                            <li>
                                                <a href="${ctx}/goods/detail/${good.id}" title="${good.name}" target="_blank">
                                                    <div>
                                                        <span title="${good.name}">${good.name}</span>
                                                        <em title="${good.caption}">${good.caption}</em>
                                                    </div>
                                                    <strong>￥${good.price}</strong>
                                                    <img src="${ctx}/upload/image/blank.gif" data-original="${good.image}" />
                                                </a>
                                            </li>
                                        [#else ]
                                            <li class="low">
                                                <a href="${ctx}/goods/detail/${good.id}" title="${good.name}" target="_blank">
                                                    <img src="${ctx}/upload/image/blank.gif" data-original="${good.image}" />
                                                    <span title="${good.caption}">${good.caption}</span>
                                                    <strong>￥${good.price}</strong>
                                                </a>
                                            </li>
                                    [/#if]
                                [/#list]
                            [/@goods_list]
                        </ul>
                    </div>
                </div>
            </div>
        [/#list]
    [/@product_category_root_list]

    [#-- 底部广告--]
    <div class="row">
        <div class="span12">
            [@ad_position id=5 /]
        </div>
    </div>

    [#--底部品牌--]
    <div class="row">
        <div class="span12">
            [@brand_list limit=10 ]
                [#if brands?has_content]
                    <div class="hotBrand">
                        <ul class="clearfix">
                            [#list brands as brand]
                                <li>
                                    <a href="${ctx}/brand/${brand.id}" title="${brand.name}">
                                        <img src="${brand.logo}" alt="${brand.name}" />
                                    </a>
                                </li>

                            [/#list]
                        </ul>
                    </div>
                [/#if]
            [/@brand_list ]
        </div>
    </div>

</div>

    [#include "include/footer.ftl"]
</body>
</html>