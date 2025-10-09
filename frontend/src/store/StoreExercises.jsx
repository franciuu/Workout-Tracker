import { create } from 'zustand';
import {fetchExercises} from '../services/ExercisesService'

export const useStoreExercises = create((set) => ({
  exercises: [],
  error: null,

  getExercises: async () => {
    try {
        const response = await fetchExercises();
        set({ exercises: response.data});
    } catch (error) {
        set({ error: error.message });
    }
  },
}));