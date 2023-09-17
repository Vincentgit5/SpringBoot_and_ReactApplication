import React from 'react';
import { Route, Navigate } from 'react-router-dom';

const AuthenticatedRoute = ({ element: Component, ...rest }) => {
  // Add your authentication logic here
  const isAuthenticated = true; // Example: assuming the user is authenticated

  return (
    <Route
      {...rest}
      element={isAuthenticated ? (
        <Component />
      ) : (
        <Navigate to="/Login" replace />
      )}
    />
  );
};

export default AuthenticatedRoute;