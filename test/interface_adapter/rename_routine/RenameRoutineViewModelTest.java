package interface_adapter.rename_routine;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class RenameRoutineViewModelTest {



    @Test
    void firePropertyChangeTest() {

        RenameRoutineViewModel viewModel = new RenameRoutineViewModel();

        class changeListener implements PropertyChangeListener {

            RenameRoutineViewModel viewModel;

            public changeListener(RenameRoutineViewModel viewModel) {
                this.viewModel = viewModel;
                viewModel.addPropertyChangeListener(this);
            }

            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }

        }


    }
}