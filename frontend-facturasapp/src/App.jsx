import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Inicio } from "./pages/Inicio";
import { Login } from "./pages/Login";

import { Mynavbar } from "./components/Mynavbar";
function App() {

  return (
    <Router>
      <Mynavbar></Mynavbar>
      <Routes>
        <Route path="/" element={<Inicio/>} />
        <Route path="/Login" element={<Login/>} />
      </Routes>
    </Router>
  )
}

export default App
