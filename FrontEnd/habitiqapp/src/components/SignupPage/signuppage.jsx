// SignupPage.jsx

import React, { useState } from 'react';
import RegistrationForm from '../../components/RegistrationForm/registrationform';
import './signuppage.css'; // Import the signup styles

function SignupPage() {
  const [showRegistration, setShowRegistration] = useState(false);
  const [showButtons, setShowButtons] = useState(true); // Add state to track button visibility

  const handleEmailSignUp = () => {
    setShowRegistration(true);
    setShowButtons(false); // Hide buttons when signing up with email
  };

  const handlegoogleSignUp = () => {
    setShowButtons(false); // Hide buttons when signing in with Google
  };

  return (
    <div className="signup-container">
      <h2 className="signup-title">Sign up</h2>
      {/* Conditionally render buttons based on showButtons state */}
      {showButtons && (
        <>
          {/* Link to Google Sign-In endpoint */}
          <button className="signupgoogle-button" onClick={handlegoogleSignUp}>Sign in with Google</button>
          {/* Link to show registration form */}
          <button className="signup-button" onClick={handleEmailSignUp}>Sign up with Email</button>
        </>
      )}
      {/* Conditionally render the RegistrationForm component */}
      {showRegistration && <RegistrationForm />}
    </div>
  );
}

export default SignupPage;
