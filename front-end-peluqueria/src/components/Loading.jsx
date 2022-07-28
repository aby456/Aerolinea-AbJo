import React from "react";

export const Loading = () => {
  return (
    <div className="spinner-border text-primary d-flex justify-content-center align-items-center" role="status">
      <span className="visually-hidden">Loading...</span>
    </div>
  );
};
