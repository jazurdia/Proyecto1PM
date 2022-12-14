package com.example.proyecto1pm.Data.Repository.Workout

import com.example.proyecto1pm.Data.Local.Dao.WorkoutDao
import com.example.proyecto1pm.Data.Local.Entity.WorkOutEnt
import com.example.proyecto1pm.Data.Resource
import com.example.proyecto1pm.Data.database.Excersise


class WorkoutRepositoryImpl(
    private val DaoWorkout: WorkoutDao
) : WorkoutRepository {

    override suspend fun getWorkouts() : Resource<List<WorkOutEnt>?> {
        val workouts = listOf(
            WorkOutEnt(
                    name ="Abdominales",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                            "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                            " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                            "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                            " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                            " amet.",
                    image = "https://us.123rf.com/450wm/artinspiring/artinspiring1903/artinspiring190300192/124762338-hombre-haciendo-abdominales-en-el-gimnasio-entrenamiento-para-quemar-el-vientre-guy-hace-ejercicio-e.jpg?ver=6",
                    intensity = "Baja",
                    repetitions = "10",
                    series = "3"
                ),
            WorkOutEnt(
                name = "Sentadillas",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                        "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                        " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                        "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                        " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                        " amet.",
                image = "https://rutinaejercicio.com/wp-content/uploads/2018/12/137.gif",
                intensity = "Media",
                repetitions = "10",
                series = "3"
            ),
            WorkOutEnt(
                name = "Flexiones",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                        "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                        " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                        "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                        " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                        " amet.",
                image = "https://us.123rf.com/450wm/robuart/robuart1810/robuart181001369/109565479-posici%C3%B3n-de-flexiones-de-yoga-mujer-en-forma-con-fuerza-en-los-brazos-hace-ejercicios-la-dama-usa-il.jpg",
                intensity = "Alta",
                repetitions = "10",
                series = "3"
            ),
            WorkOutEnt(
                name = "Zancadas",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                        "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                        " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                        "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                        " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                        " amet.",
                image = "https://rutinaejercicio.com/wp-content/uploads/2018/12/135.gif",
                intensity = "Media",
                repetitions = "10",
                series = "3"
            ),
            WorkOutEnt(
                name = "Plancha",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                        "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                        " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                        "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                        " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                        " amet.",
                image = "https://static.vecteezy.com/system/resources/previews/005/906/676/original/woman-doing-plank-hip-dips-exercise-flat-illustration-isolated-on-white-background-free-vector.jpg",
                intensity = "Baja",
                repetitions = "10",
                series = "3"
            ),
            WorkOutEnt(
                name = "Burpees",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                        "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                        " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                        "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                        " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                        " amet.",
                image = "https://us.123rf.com/450wm/lioputra/lioputra2010/lioputra201000163/157833604-gu%C3%ADa-de-ejercicios-con-un-hombre-haciendo-la-posici%C3%B3n-squat-thrust-burpee-en-3-pasos-ilustraci%C3%B3n-sob.jpg?ver=6",
                intensity = "Alta",
                repetitions = "10",
                series = "3"
            ),
            WorkOutEnt(
                name = "Peso muerto",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis fringilla pellentesque ipsum " +
                        "id eleifend. Integer aliquet mattis odio a convallis. In vel dictum nisl, nec molestie" +
                        " tellus. Donec in risus et libero aliquam ornare. Pellentesque et lorem vel eros " +
                        "condimentum rhoncus nec et purus. Vestibulum malesuada mi non elit vehicula fringilla" +
                        " efficitur at metus. Maecenas porta gravida dolor, vel scelerisque libero facilisis sit" +
                        " amet.",
                image = "https://media.istockphoto.com/vectors/man-doing-barbell-stiff-leg-deadlift-exercise-flat-vector-isolated-vector-id1408890976?k=20&m=1408890976&s=612x612&w=0&h=XrARt2xQAw-zgODcgyVVf65OTSDqpt3tf8HP3Q3TBRU=",
                intensity = "Alta",
                repetitions = "10",
                series = "3"
            ),
        )
        return Resource.Success(workouts)

    }

    override suspend fun getUniqueWorkout(workout: WorkOutEnt): Resource<WorkOutEnt?> {
        return try{
            val UniqueLocalW = DaoWorkout.getUniqueWorkout(workout.name)
            if (UniqueLocalW!=null){
                return Resource.Success(UniqueLocalW)
            }else{
                return  Resource.Error("No se encontr?? base de datos local")
            }
        }catch (ex : Exception){
            return Resource.Error(ex.message?:"error inesperado")
        }
    }
}