// LoginPage.jsx

import React from 'react';

function LoginPage() {
  return (
    <div className="flex flex-col justify-center items-center min-h-screen">
      <h2 className="text-2xl font-semibold mb-4">Login</h2>
      <form className="w-1/3">
        <div className="mb-4">
          <label htmlFor="username" className="block mb-2">Usernames:</label>
          <input type="text" id="username" name="username" className="border border-gray-300 rounded-md p-2 w-full" />
        </div>
        <div className="mb-4">
          <label htmlFor="password" className="block mb-2">Password:</label>
          <input type="password" id="password" name="password" className="border border-gray-300 rounded-md p-2 w-full" />
        </div>
        <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded-md hover:bg-blue-600">Login</button>
      </form>
    </div>
  );
}

export default LoginPage;
