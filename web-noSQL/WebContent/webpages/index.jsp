<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Sell Repeat</title>
<link href="bbr.css" rel="stylesheet" type="text/css" media="screen"></head>
<body>

<div class = wrapper>

<div id = header>

<div id= logo>
<a href="http://localhost:8080/web-noSQL/webpages/index.jsp"><img src=Sample_photos/logo/main_logo.jpg></a>
<div id = Quote>
<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
<p>Buy or sell anything at a price that suits you</p>
</div>
</div>

<div id= links>
<li class="active"><a href='index.jsp'><span>Home</span></a></li>
<li class="active"><a href='to_buy.jsp'><span>For sale</span></a></li>
<li class="active"><a href='login.jsp'><span>Login</span></a></li>
<li class="active"><a href='contact.jsp'><span>Contact</span></a></li>
</div>

</div>

</div>
<div class = Top_Categories>
<div id= top_cat1>
<img  src=Sample_photos/House_Category/henery.jpg width="100%" height="300">
<div id= link1>
<a href='to_buy.jsp'><span>click to browse</span></a>
</div>

</div>
<div id= top_cat2>
<img src=Sample_photos/Motor_category/a6.jpg width="100%" height="300">

<div id= link2>
<a href='to_buy.jsp'><span>click to browse</span></a>
</div>
</div>
<div id=heading>
<h1><b>Top Categories</b></h1>
</div>
<div id= top_cat3>
<div class = tech_category>
<img  src=Sample_photos/tech_category/ps4.jpg width="100%" height="300">

<div id= link3>
<a href='to_buy.jsp'><span>click to browse</span></a>
</div>
</div>

</div>
</div>
<div id= top_cat4>
<div class=animal_images>
  <img src=Sample_photos/animal_category/Puppy_2_kbhb4a.jpg width="100%" height="300">

</div>
<div id= link4>
<a href='to_buy.jsp'><span>click to browse</span></a>
</div>
</div>
</div>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides2");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides3");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides4");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
<div class = footer>
<div id= contact>
<h5> Contact</h5>
<p>Email: info@buildbuyrepeat.com</p>
<p>Phone: 1234567891</P>
</p>
</div>

<div id= web_links>
<a href="http://www.facebook.com"><img src=Sample_photos/facebook.jpg width="50" height="50"></a>
<a href="http://www.twitter.com"><img src=Sample_photos/twitter.jpg width="50" height="50"></a>
</div>
</body>
</html>