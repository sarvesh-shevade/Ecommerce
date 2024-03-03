
import {BrowserRouter as  Router,Route,Routes } from "react-router-dom";
import WebFont from "webfontloader";
import React from "react";
import Header from "./components/layout/Header/Header.js";
import Footer from "./components/layout/Footer/Footer.js";
import Home from "./components/Home/Home.js";
import "./App.css";

function App() {
   
  React.useEffect(() => {
    WebFont.load({
      google:{
        families: ["Roboto","Droid Sans","Chilanka"],
      },
    });
  },[]);


  return (
    <Router>
      <Header/>
      <Routes>
      <Route exact path="/" Component={Home}/>
      </Routes>
      <Footer/>
      
   </Router>
  );
}

export default App;
