/*-----------------------------------------------------------------------------------*/
/*	POSTS GRID
/*-----------------------------------------------------------------------------------*/ 
$(window).load(function(){
    var $container = $('.blog-grid');

    var gutter = 30;
    var min_width = 345;
    $container.imagesLoaded( function(){
        $container.masonry({
            itemSelector : '.post',
            gutterWidth: gutter,
            isAnimated: true,
              columnWidth: function( containerWidth ) {
                var box_width = (((containerWidth - gutter)/2) | 0) ;

                if (box_width < min_width) {
                    box_width = (((containerWidth - gutter)/2) | 0);
                }

                if (box_width < min_width) {
                    box_width = containerWidth;
                }

                $('.post').width(box_width);

                return box_width;
              }
        });
        $container.css( 'visibility', 'visible' ).parent().removeClass( 'loading' );
    });
});

    
/*-----------------------------------------------------------------------------------*/
/*	BUTTON HOVER
/*-----------------------------------------------------------------------------------*/

jQuery(document).ready(function($)  {
$("a.button, .forms fieldset .btn-submit, #commentform input#submit").css("opacity","1.0");
$("a.button, .forms fieldset .btn-submit, #commentform input#submit").hover(function () {
$(this).stop().animate({ opacity: 0.85 }, "fast");  },
function () {
$(this).stop().animate({ opacity: 1.0 }, "fast");  
}); 
});

/*-----------------------------------------------------------------------------------*/
/*	IMAGE HOVER
/*-----------------------------------------------------------------------------------*/		
		
jQuery(document).ready(function($) {	
$('.quick-flickr-item').addClass("frame");
$('.frame a').prepend('<span class="more"></span>');
});

jQuery(document).ready(function($) {
        $('.frame').mouseenter(function(e) {

            $(this).children('a').children('span').fadeIn(300);
        }).mouseleave(function(e) {

            $(this).children('a').children('span').fadeOut(200);
        });
    });	

/*-----------------------------------------------------------------------------------*/
/*	MENU
/*-----------------------------------------------------------------------------------*/
ddsmoothmenu.init({
	mainmenuid: "menu",
	orientation: 'h',
	classname: 'menu',
	contentsource: "markup"
})

/*自适应*/
jQuery(document).ready(function($) {	
	if(document.documentElement.clientWidth<document.documentElement.clientHeight){
		$(".content").css("width","100%");
        $(".wrapper").css("width","100%");
        $(".sidebar").css("width","100%");
        $(".header").css("width","100%");
        $("#menu-wrapper .menu ul li").css("padding-left","5px");
        $("#menu-wrapper .menu ul li").css("margin-left","5px");
	}
});