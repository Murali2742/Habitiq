import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
// index.js or App.js





import LoginPage from './components/LoginPage/loginpage';
import SignupPage from './components/SignupPage/signuppage';
import HomePage from './components/HomePage/homepage';


function App() {
  return (
    <Router>

<div className="App">
        <div className="nav-container">
          <ul>
            <li><Link to="/home">Home</Link></li>
            <li><Link to="/login" className="button-left">Login</Link></li>
            <li><Link to="/signup" className="button-right">Signup</Link></li>
          </ul>
        </div>

      <Routes>
            <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path="/home" element={<HomePage/>} />
          <Route path="/" element={<HomePage/>} />
        
      </Routes>


  
   
    </div>


    </Router>
    
  );
}

export default App;
