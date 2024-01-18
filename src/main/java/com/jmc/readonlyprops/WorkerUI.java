package com.jmc.readonlyprops;

import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class WorkerUI extends GridPane {
    private final Label title = new Label();
    private final Label massage = new Label();
    private final Label running = new Label();
    private final Label state = new Label();
    private final Label totalWork = new Label();
    private final Label workDone = new Label();
    private final Label progress = new Label();
    private final ProgressBar progressBar = new ProgressBar();
    private final TextArea value = new TextArea();
    private  final  TextArea exception = new TextArea();

    public WorkerUI(Worker<ObservableList<Integer>> worker){
            addUI();
            bindToWorker(worker);
    }

    private void addUI() {
        value.setPrefColumnCount(20);
        value.setPrefColumnCount(4);
        value.setWrapText(true);
        exception.setPrefColumnCount(20);
        exception.setPrefColumnCount(5);
        this.setHgap(5);
        setVgap(5);
        addRow(0, new Label("TÍtulo "), title);
        addRow(1, new Label("Mensaje "), massage);
        addRow(2, new Label("Corriendo "), running);
        addRow(3, new Label("Estado "), state);
        addRow(4, new Label("Total trabajadores "), totalWork);
        addRow(5, new Label("Trabajo terminado "), workDone);
        addRow(6, new Label("Progreso "), new HBox(2, progressBar, progress));
        addRow(7, new Label("Valor "), value);
        addRow(8, new Label("Excepcion "), exception);
    }
    private void bindToWorker(Worker<ObservableList<Integer>> worker) {
        title.textProperty().bind(worker.titleProperty());
        massage.textProperty().bind(worker.messageProperty());
        running.textProperty().bind(worker.messageProperty());
        state.textProperty().bind(worker.stateProperty().asString());
        totalWork.textProperty().bind(new When(worker.totalWorkProperty().isEqualTo(-1))
                .then("Unknown")
                .otherwise(worker.totalWorkProperty().asString()));
        workDone.textProperty().bind(new When(worker.totalWorkProperty().isEqualTo(-1))
                .then("Unknown")
                .otherwise(worker.workDoneProperty().asString()));
        progress.textProperty().bind(new When(worker.progressProperty().isEqualTo(-1))
                .then("Unknown")
                .otherwise(worker.progressProperty().multiply(100).asString("%.2f%%")));
        progressBar.progressProperty().bind(worker.progressProperty());
        value.textProperty().bind(worker.valueProperty().asString());
        worker.exceptionProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                exception.setText(newVal.getMessage());
            } else {
                exception.setText("");
            }
        });

    }
}
/*
La interfaz `Worker<V>` es una interfaz de JavaFX que representa una tarea asíncrona, que puede ejecutarse en segundo plano para realizar operaciones que no deben bloquear la interfaz de usuario. La interfaz `Worker` es genérica y toma un tipo de resultado `V` como parámetro de tipo.

descripción de los métodos que define esta interfaz:

1. **getState():**
   - Devuelve el estado actual de la tarea, representado por un valor del tipo enumerado `State`.

2. **stateProperty():**
   - Devuelve una propiedad de solo lectura que representa el estado de la tarea. Puedes registrar oyentes en esta propiedad para ser notificado cuando el estado cambie.

3. **getValue():**
   - Devuelve el resultado de la tarea, que es de tipo `V`.

4. **valueProperty():**
   - Devuelve una propiedad de solo lectura que representa el resultado de la tarea. Puedes registrar oyentes en esta propiedad para ser notificado cuando el resultado cambie.

5. **getException():**
   - Devuelve la excepción que ocurrió durante la ejecución de la tarea, o `null` si la tarea se completó sin excepciones.

6. **exceptionProperty():**
   - Devuelve una propiedad de solo lectura que representa la excepción ocurrida durante la ejecución de la tarea. Puedes registrar oyentes en esta propiedad para ser notificado cuando la excepción cambie.

7. **getWorkDone():**
   - Devuelve la cantidad de trabajo completado hasta el momento.

8. **workDoneProperty():**
   - Devuelve una propiedad de solo lectura que representa la cantidad de trabajo completado. Puedes registrar oyentes en esta propiedad para ser notificado cuando el trabajo completado cambie.

9. **getTotalWork():**
   - Devuelve la cantidad total de trabajo que la tarea tiene que realizar.

10. **totalWorkProperty():**
    - Devuelve una propiedad de solo lectura que representa la cantidad total de trabajo que la tarea tiene que realizar. Puedes registrar oyentes en esta propiedad para ser notificado cuando la cantidad total de trabajo cambie.

11. **getProgress():**
    - Devuelve el progreso actual de la tarea como un valor entre 0.0 y 1.0, calculado como `workDone / totalWork`.

12. **progressProperty():**
    - Devuelve una propiedad de solo lectura que representa el progreso de la tarea. Puedes registrar oyentes en esta propiedad para ser notificado cuando el progreso cambie.

13. **isRunning():**
    - Devuelve `true` si la tarea está actualmente en ejecución (en el estado `RUNNING`), de lo contrario, devuelve `false`.

14. **runningProperty():**
    - Devuelve una propiedad de solo lectura que representa si la tarea está en ejecución. Puedes registrar oyentes en esta propiedad para ser notificado cuando el estado de ejecución cambie.

15. **getMessage():**
    - Devuelve un mensaje relacionado con el progreso o el estado actual de la tarea.

16. **messageProperty():**
    - Devuelve una propiedad de solo lectura que representa el mensaje relacionado con el progreso o el estado actual de la tarea. Puedes registrar oyentes en esta propiedad para ser notificado cuando el mensaje cambie.

17. **getTitle():**
    - Devuelve el título asociado con la tarea.

18. **titleProperty():**
    - Devuelve una propiedad de solo lectura que representa el título asociado con la tarea. Puedes registrar oyentes en esta propiedad para ser notificado cuando el título cambie.

19. **cancel():**
    - Intenta cancelar la tarea. Devuelve `true` si la tarea se pudo cancelar, de lo contrario, devuelve `false`.

20. **State Enum:**
    - La enumeración `State` define los posibles estados de la tarea, como `READY`, `SCHEDULED`, `RUNNING`, `SUCCEEDED`, `CANCELLED` y `FAILED`.

Esta interfaz proporciona un conjunto completo de métodos y propiedades para monitorear y gestionar tareas asíncronas en JavaFX, facilitando la actualización de la interfaz de usuario en respuesta al progreso o resultados de la tarea.
 */

