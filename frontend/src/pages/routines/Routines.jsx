import "./Routines.css";
import RoutineCard from "../../components/routineCard/RoutineCard";
import { useNavigate } from "react-router-dom";

const Routines = () => {
  const navigate = useNavigate();

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
          <RoutineCard/>
        </div>
      </div>
    </div>
  );
};

export default Routines;