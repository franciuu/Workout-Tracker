import "./Routines.css";
import RoutineCard from "../../components/routineCard/RoutineCard";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { fetchRoutines } from "../../services/RoutineService";

const Routines = () => {
  const [routines, setRoutines] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const getRoutines = async () => {
      try {
        const response = await fetchRoutines();
        setRoutines(response.data);
      } catch (error) {
        console.log(error);
      }
    }
    getRoutines();
  }, []);

  return (
    <div className="routines-page">
      <div className="routines-container">
        <div className="routines-header">
          <div>
            <h1 className="routines-title">My Routines</h1>
            <p className="routines-subtitle">Create and manage your workout routines</p>
          </div>
          <button className="create-routine-btn" onClick={() => navigate("/create-routine")}>
            <i className="bi bi-plus-lg"></i>
            Create Routine
          </button>
        </div>

        <div className="routines-grid">
          {routines.map((routine, index) => (
            <RoutineCard key={index} routine={routine}/>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Routines;