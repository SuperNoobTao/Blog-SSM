/**
 * @license Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
	// 界面语言，默认为 'en'
    config.language = 'zh-cn';
    // 设置宽高
    config.width = 1000;
    config.height = 900;
    // 编辑器样式，有三种：'kama'（默认）、'office2003'、'v2'
    config.skin = 'office2013';
    // 背景颜色
    //config.uiColor = '#11AAAA';
    // 工具栏（基础'Basic'、全能'Full'、自定义）plugins/toolbar/plugin.js
    //config.toolbar = 'Basic';
	config.toolbar = 'Full';
	//工具栏是否可以被收缩
    config.toolbarCanCollapse = true;
	
	config.toolbar_Full = [
       ['Source','-','Save','NewPage','Preview','-','Templates'],
       ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
       ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
       ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
       '/',
       ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
        ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
        ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
        ['Link','Unlink','Anchor'],
       ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
       '/',
        ['Styles','Format','Font','FontSize'],
        ['TextColor','BGColor']
    ];
    config.allowedContent=true;//关闭标签过滤
    config.fullPage = true;//允许包含html标签
    config.formatSource = false; //在切换到代码视图时是否自动格式化代码
    config.formatOutput = false; //当输出内容时是否自动格式化代码
    config.formatIndentator = '    '; //当在源码格式下缩进代码使用的字符
    //config.entities = false;
    //字体
    config.font_names="宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;" + config.font_names;

    //后台图片上传路径
    config.filebrowserUploadUrl="/MyBlog/manage/uploadImage.action";
};
