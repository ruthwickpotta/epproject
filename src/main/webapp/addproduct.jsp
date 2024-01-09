<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="/includes/head.jsp"%>
<title>Insert title here</title>
<style>
  .button1 {
  display: inline-block;
  padding: 10px 20px;
  border-radius: 20px;
  background-color: #ff69b4;
  color: #ffffff;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
  font-weight: bold;
  box-shadow: 0 0 10px #ff69b4;
  transition: box-shadow 0.3s;
  position: fixed;
  top: 20px;
  right: 20px;
  z-index: 9999;
  overflow: hidden;
}

.button1:before, .button1:after {
  content: '';
  position: absolute;
  top: -2px;
  left: -2px;
  width: 100%;
  height: 100%;
  background: linear-gradient(45deg, #00ff00, #ffff00, #00ff00, #ffff00);
  z-index: -1;
  opacity: 0;
  transition: opacity 0.3s;
}

.button1:before {
  filter: blur(5px);
}

.button1:after {
  filter: blur(10px);
}

.button1:hover {
  box-shadow: 0 0 20px #ff69b4, 0 0 20px #00ff00;
}

.button1:hover:before, .button1:hover:after {
  opacity: 1;
}

@keyframes floating {
  0% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-10px);
  }
  100% {
    transform: translateY(0);
  }
}
  
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background: linear-gradient(45deg, #ffe5ea 50%, #fffacd 50%);
    }
  
    h1 {
      text-align: center;
      color: #333333;
    }
  
    .form-container {
      max-width: 500px;
      margin: 0 auto;
      background-color: rgba(255, 255, 255, 0.7);
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
      position: relative;
      overflow: hidden;
    }
  
    .form-group {
      margin-bottom: 20px;
    }
  
    label {
      display: block;
      margin-bottom: 5px;
      color: #555555;
      font-weight: bold;
    }
  
    input[type="text"],
    input[type="email"],
    select,
    textarea {
      width: 100%;
      padding: 10px;
      border: 1px solid #dddddd;
      border-radius: 5px;
      outline: none;
      font-size: 16px;
      transition: border-color 0.3s ease-in-out;
      background-color: #ffffff;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
    }
  
    input[type="text"]:focus,
    input[type="email"]:focus,
    select:focus,
    textarea:focus {
      border-color: #5c9ce6;
      box-shadow: 0 0 5px rgba(92, 156, 230, 0.5);
    }
  
    input[type="file"] {
      padding: 5px;
    }
  
    input[type="submit"] {
      background-color: #3d8fd1;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      transition: background-color 0.3s ease-in-out;
      position: relative;
      overflow: hidden;
    }
  
    input[type="submit"]:hover {
      background-color: #3498db;
    }
  
    input[type="submit"]:before {
      content: '';
      background-color: rgba(255, 255, 255, 0.4);
      width: 120%;
      height: 100%;
      position: absolute;
      top: 0;
      left: -10%;
      transform: skewX(-25deg);
      transition: transform 0.5s;
      z-index: -1;
    }
  
    input[type="submit"]:hover:before {
      transform: skewX(-25deg) translateX(100%);
    }
  
    .dropdown {
      position: relative;
    }
  
    .dropdown select {
      width: 100%;
      appearance: none;
      -webkit-appearance: none;
      padding-right: 30px;
      background-color: #ffffff;
      cursor: pointer;
    }
  
    .dropdown select::-ms-expand {
      display: none;
    }
  
    .dropdown:after {
      content: "\25BC";
      position: absolute;
      top: calc(50% - 5px);
      right: 10px;
      color: #555555;
      pointer-events: none;
      transition: transform 0.3s ease-in-out;
    }
  
    .dropdown:hover:after {
      transform: translateY(2px);
    }
  
    .photo-upload {
      display: flex;
      align-items: center;
    }
  
    .photo-upload label {
      margin-right: 10px;
    }
  
    .form-container:before,
    .form-container:after {
      content: "";
      position: absolute;
      top: -10px;
      left: -10px;
      right: -10px;
      bottom: -10px;
      background-color: rgba(255, 255, 255, 0.2);
      border-radius: 15px;
      z-index: -1;
      animation: neon-glow 1.5s ease-in-out infinite alternate;
    }
  
    .form-container:before {
      transform: rotate(45deg);
    }
  
    .form-container:after {
      transform: rotate(-45deg);
    }
  
    @keyframes neon-glow {
      0% {
        box-shadow: 0 0 10px #ff1493, 0 0 20px #00ffff;
      }
      100% {
        box-shadow: 0 0 20px #ff1493, 0 0 30px #00ffff;
      }
    }
  
    /* Additional styles for field colors */
  
    input[type="text"],
    input[type="email"],
    select,
    textarea {
      background-color: #f9f9f9;
    }
  
    input[type="text"]:focus,
    input[type="email"]:focus,
    select:focus,
    textarea:focus {
      background-color: #eaeaea;
    }
  
    /* Additional styles for the form submit button */
  
    input[type="submit"] {
      background-color: #ff6b6b;
      border-radius: 50px;
      overflow: hidden;
      transition: background-color 0.3s ease-in-out;
    }
  
    input[type="submit"]:hover {
      background-color: #ff4f4f;
    }
  
    input[type="submit"]:before {
      width: 200%;
      left: -50%;
      transition: transform 0.5s;
    }
  
    input[type="submit"]:hover:before {
      transform: skewX(-25deg) translateX(50%);
    }
  </style>
</head>
<body>

     
<%@include file="anavbar.jsp"%>
 
  <div class="form-container">
    <form action="Storeproduct" method="post"  enctype="multipart/form-data">
      <div class="form-group">
        <label for="company-name">Name</label>
        <input type="text" id="proname" name="proname" required>
      </div>
      <div class="form-group">
        <label for="company-photo">Product Image (JPEG/PNG)</label>
        <div class="photo-upload">
          <label for="company-photo" class="file-label">Choose File</label>
          <input type="file" id="prophoto" name="prophoto" accept="image/png, image/jpeg">
        </div>
      </div>
      <div class="form-group">
        <label for="contact-number">Price</label>
        <input type="text" id="proprice" name="proprice" required>
      </div>
    	<div class="form-group">
        <label for="branch">Category</label>
        <div class="dropdown">
          <select id="category" name="category" required>
            <option value="">Select Category</option>
            <option value="Electronic">Electronics</option>
            <option value="Apparel">Apparel</option>
            <option value="Furniture">Furniture</option>
            <option value="Grocery">Grocery</option>
            <option value="Beauty">Beauty</option>
          </select>
        </div>
      </div>
      <div class="form-group">
        <input type="submit" value="Submit">
      </div>
    </form>
  </div>
  <%@include file="/includes/footer.jsp"%>
</body>



</html>