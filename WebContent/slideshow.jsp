<div class="slidebox">                
<div class="slideShowContainer">
<ul class="slideShow">
<a><img src="images/add2.jpg" /></a>
<a><img src="images/add3.jpg"  /></a>
</ul>
</div> 
</div> 
    
   
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
$(function(){	
	
	var slides = $('.slideShow>a');
	var slideCount = 0;
	var totalSlides = slides.length;
	var slideCache = [];
	
	(function preLoader(){		
		if(slideCount < totalSlides){			
			slideCache[slideCount] = new Image();
			slideCache[slideCount].src = slides.eq(slideCount).find('img').attr('src');
			slideCache[slideCount].onload=function(){
				slideCount++;
				preLoader();
			}
		}
		else{						
			slideCount = 0;
			SlideShow();
		}
	}());
	
	function SlideShow(){	
		
		slides.eq(slideCount).fadeIn(3000).delay(5000).fadeOut(500, function(){
			slideCount<totalSlides -1 ? slideCount++: slideCount=0;					
			SlideShow();
		})
	}
	
})
</script>


