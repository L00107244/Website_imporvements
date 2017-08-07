<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java_classes.sign_up_backend" %>
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
<a href="http://localhost:8080/web-SQL/webpages/index.jsp"><img src= "Sample_photos/logo/main_logo.JPG"></a>
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
<div id= microphone_op>
<form action="/action_page.php">
  <input type="image" src= "Sample_photos/buttons/microphone.jpg"width="30" height="30"alt="Speech_navigation">
</form>
</div>
</div>
<div class= login>
<div id= heading>
<h2>Update your records</h2>
<p>Please fill out the boxes to update the information</p>
        <form method="post" action="" name="form2" id="my_sign-up_form">
          <ol>
            <li>
              <label for="first-name">Username</label>
              <input type="text" name="username">
            </li>
             <li>
              <label for="password">Password</label>
              <input type="password" name="password">
            </li>
            <li>
            <label for="email">Email</label>
            <input type="text" name="email">
            </li>
            <li>
            <label for="pn">Phone Number</label>
            <input type="text" name="phoneNum">
            <li>
              <input class="submit" type="submit" name="submit" value="submit">
            </li>
          </ol>
          <p>To go back to the home page click here <a href='sign-up.jsp'>here</a>.</p> 
         <%
         if(request.getParameter("submit")!= null)
         {
        	String user = request.getParameter("username");
        	String pass = request.getParameter("password");
        	String email = request.getParameter("email");
        	String phoneNumber = request.getParameter("phoneNum");
        	sign_up_backend update = new sign_up_backend();
        	int ID = update.getid();
        	int updateRec = 0;
        	updateRec = update.updateRecord(ID, user, pass, email, phoneNumber);
        	if(updateRec==1)
        	{
        		System.out.println("Record updated");
        	}

         }
         %>

</div>
</div>

<div class = footer>
<div id= contact>
<h5> Contact</h5>
<p>Email: info@buildbuyrepeat.com</p>
<p>Phone: 1234567891</P>
</p>
</div>

<div id= web_links>
<a href="http://www.facebook.com"><img src=Sample_photos/icons/facebook.jpg width="50" height="50"></a>
<a href="http://www.twitter.com"><img src=Sample_photos/icons/twitter.jpg width="50" height="50"></a>
</div>
</body>
</html>