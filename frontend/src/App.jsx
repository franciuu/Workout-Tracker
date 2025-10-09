import { Route, Routes } from "react-router-dom"
import { useEffect } from "react"
import Exercises from "./pages/exercises/Exercises"
import LandingPage from "./pages/landingpage/LandingPage"
import MainNavBar from "./components/mainNavBar/mainNavBar"
import Dashboard from "./pages/dashboard/Dashboard"
import Routines from "./pages/routines/Routines"
import History from "./pages/history/History"
import Badges from "./pages/badges/Badges"
import { useStoreExercises } from './store/StoreExercises';
import "./App.css";

function App() {
  // const { getExercises } = useStoreExercises();

  // useEffect(() => {
  //   getExercises();
  // }, [getExercises]);

  return (
    <div>
      <MainNavBar/>
      <Routes>
        <Route path="/exercises" element={<Exercises/>}/>
        <Route path="/" element={<LandingPage/>}/>
        <Route path="/dashboard" element={<Dashboard/>}/>
        <Route path="/routines" element={<Routines/>}/>
        <Route path="/history" element={<History/>}/>
        <Route path="/badges" element={<Badges/>}/>
      </Routes>
    </div> 
  )
}

export default App
