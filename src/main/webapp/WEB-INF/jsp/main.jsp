<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<%@include file="common/head.jsp"%>
<!DOCTYPE html>
<html>
    <title>主页面</title>

<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页 ${userName}</a>
                </li>
                <li>
                    <a href="#">简介</a>
                </li>
                <li class="disabled">
                    <a href="#">信息</a>
                </li>
                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">操作</a>
                        </li>
                        <li>
                            <a href="#">设置栏目</a>
                        </li>
                        <li>
                            <a href="#">更多设置</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="row clearfix">
                <div class="col-md-2 column">
                    <div class="panel-group" id="panel-626523">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-626523" href="#panel-element-680358">Collapsible Group Item #1</a>
                            </div>
                            <div id="panel-element-680358" class="panel-collapse collapse">
                                <div class="panel-body">
                                    Anim pariatur cliche...
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-626523" href="#panel-element-485884">Collapsible Group Item #2</a>
                            </div>
                            <div id="panel-element-485884" class="panel-collapse collapse">
                                <div class="panel-body">
                                    Anim pariatur cliche...
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-10 column">
                    <dl>
                        <dt>
                            Description lists
                        </dt>
                        <dd>
                            A description list is perfect for defining terms.
                        </dd>
                        <dt>
                            Euismod
                        </dt>
                        <dd>
                            Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.
                        </dd>
                        <dd>
                            Donec id elit non mi porta gravida at eget metus.
                        </dd>
                        <dt>
                            Malesuada porta
                        </dt>
                        <dd>
                            Etiam porta sem malesuada magna mollis euismod.
                        </dd>
                        <dt>
                            Felis euismod semper eget lacinia
                        </dt>
                        <dd>
                            Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>