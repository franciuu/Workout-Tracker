import { useState } from "react";

export const useDragAndDrop = (setItems) => {
  const [draggedIndex, setDraggedIndex] = useState(null);
  const [dragOverIndex, setDragOverIndex] = useState(null);

  const handleDragStart = (index, e) => {
    setDraggedIndex(index);
    e.dataTransfer.effectAllowed = 'move'; 
    e.dataTransfer.setData('text/plain', index.toString()); 
  };

  const handleDragOver = (index, e) => {
    e.preventDefault();
    e.dataTransfer.dropEffect = 'move';
    if (draggedIndex === null) return;
    if (index !== draggedIndex) setDragOverIndex(index);
  };

  const handleDrop = (dropIndex, e) => {
    e.preventDefault();
    if (draggedIndex === null || draggedIndex === dropIndex) return;

    setItems((prevItems) => {
      const newItems = [...prevItems];
      const draggedItem = newItems.splice(draggedIndex, 1)[0];
      newItems.splice(dropIndex, 0, draggedItem);
      return newItems;
    });

    setDraggedIndex(null);
    setDragOverIndex(null);
  };

  const handleDragEnd = () => {
    setDraggedIndex(null);
    setDragOverIndex(null);
  };

  return {
    draggedIndex,
    dragOverIndex,
    handleDragStart,
    handleDragOver,
    handleDrop,
    handleDragEnd
  };
};
