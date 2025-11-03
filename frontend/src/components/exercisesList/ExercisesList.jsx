import { useState } from "react";
import "./ExercisesList.css";
import { useDragAndDrop } from "../../hooks/useDragAndDrop";

const ExercisesList = ({exercises, onSearchChange, selectedExercises, setSelectedExercises}) => {
  const [searchQuery, setSearchQuery] = useState("");

  const addExercise = (exerciseId) => {
    if (!selectedExercises.find(ex => ex.exerciseId === exerciseId)) {
      const exercise = exercises.find(ex => ex.exerciseId === exerciseId);
      setSelectedExercises([...selectedExercises, { ...exercise, sets: 3, reps: 10, weight: 10, orderIndex: selectedExercises.length }]);
    }
  };

  const removeExercise = (exerciseId) => {
    setSelectedExercises(selectedExercises.filter(ex => ex.exerciseId !== exerciseId));
  };

  const updateExercise = (exerciseId, field, value) => {
    setSelectedExercises(selectedExercises.map(ex => 
      ex.exerciseId === exerciseId ? { ...ex, [field]: parseInt(value) || 0 } : ex
    ));
  };

  const handleSearch = (e) => {
    setSearchQuery(e.target.value)
    onSearchChange(e.target.value);
  }

  const {
    draggedIndex,
    dragOverIndex,
    handleDragStart,
    handleDragOver,
    handleDrop,
    handleDragEnd
  } = useDragAndDrop(setSelectedExercises);

  return (
    <div className="exercises-list-container">
      <div className="exercises-left-column">
        <div className="exercises-list-card">
          <div className="exercises-list-header">
            <div className="header-left">
              <h3 className="exercises-list-title">Selected Exercises</h3>
              <span className="exercises-count">{selectedExercises.length}</span>
            </div>
          </div>
          <div className="exercises-list-body">
            {selectedExercises.length === 0 ? (
              <div className="empty-state">
                <p className="empty-state-text">No exercises added yet</p>
                <p className="empty-state-subtext">Select exercises from the right panel</p>
              </div>
            ) : (
              <div className="selected-exercises-list">
                {selectedExercises.map((exercise, index) => (
                  <div 
                    key={exercise.exerciseId} 
                    className={`exercise-item ${draggedIndex === index ? 'exercise-item-dragging' : ''} ${dragOverIndex === index ? 'exercise-item-drag-over' : ''}`}
                    draggable
                    onDragStart={(e) => handleDragStart(index, e)}
                    onDragOver={(e) => handleDragOver(index, e)}
                    onDrop={(e) => handleDrop(index, e)}
                    onDragEnd={handleDragEnd}
                  >
                    <div className="exercise-item-header">
                      <div className="exercise-name-wrapper">
                        <div className="drag-handle">
                            <i class="bi bi-list"></i>
                        </div>
                        <span className="exercise-order">{index + 1}</span>
                        <span className="exercise-name">{exercise.name}</span>
                      </div>
                      <button 
                        className="remove-btn"
                        onClick={(e) => {
                          e.stopPropagation();
                          removeExercise(exercise.exerciseId);
                        }}
                      >
                        <i class="bi bi-trash"></i>
                      </button>
                    </div>
                    <div className="exercise-inputs">
                      <div className="input-group">
                        <label>Sets</label>
                        <input 
                          type="number" 
                          value={exercise.sets}
                          onChange={(e) => updateExercise(exercise.exerciseId, 'sets', e.target.value)}
                          onClick={(e) => e.stopPropagation()}
                          min="1"
                        />
                      </div>
                      <div className="input-group">
                        <label>Reps</label>
                        <input 
                          type="number" 
                          value={exercise.reps}
                          onChange={(e) => updateExercise(exercise.exerciseId, 'reps', e.target.value)}
                          onClick={(e) => e.stopPropagation()}
                          min="1"
                        />
                      </div>
                      <div className="input-group">
                        <label>Weight</label>
                        <input 
                          type="number" 
                          value={exercise.weight}
                          onChange={(e) => updateExercise(exercise.exerciseId, 'weight', e.target.value)}
                          onClick={(e) => e.stopPropagation()}
                          min="0"
                        />
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>
      </div>

      <div className="exercises-right-column">
        <div className="exercises-picker-card">
          <div className="exercises-picker-header">
            <h3 className="exercises-picker-title">Available Exercises</h3>
            <div className="search-wrapper">
              <i class="bi bi-search search-icon"></i>
              <input 
                type="text"
                className="search-input"
                placeholder="Search exercises..."
                value={searchQuery}
                onChange={handleSearch}
              />
            </div>
          </div>
          <div className="exercises-picker-body">
            {exercises.map((exercise) => (
              <button
                key={exercise.exerciseId}
                className="exercise-picker-item"
                onClick={() => addExercise(exercise.exerciseId)}
                type="button"
              >
                <div className="exercise-picker-content">
                  <div className="exercise-picker-name">{exercise.name}</div>
                </div>
                <div className="exercise-picker-action">
                  <i class="bi bi-plus"></i>
                </div>
              </button>
            ))}
            {exercises.length === 0 && (
              <p className="no-results">No exercises found</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default ExercisesList;