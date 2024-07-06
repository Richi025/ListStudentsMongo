import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import NewStudentForm from './components/NewStudentForm';
import StudentList from './components/StudentList';

/**
 * Main application component.
 * 
 * This component sets up the application routing using React Router.
 * It provides navigation links and defines routes for different components.
 */
const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <Link to="/">Home</Link> | <Link to="/students">Student List</Link>
        </nav>
        <Routes>
          <Route path="/" element={<NewStudentForm />} />
          <Route path="/students" element={<StudentList />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
