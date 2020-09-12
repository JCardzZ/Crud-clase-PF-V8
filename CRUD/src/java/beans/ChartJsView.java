package beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

@Named
@RequestScoped
public class ChartJsView implements Serializable {
     
    private PieChartModel pieModel;
     
 
 
    @PostConstruct
    public void init() {
        createPieModel();

    }
     
    private void createPieModel() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
         
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);
         
        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);
         
        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Red");
        labels.add("Blue");
        labels.add("Yellow");
        data.setLabels(labels);
         
        pieModel.setData(data);
    }
     

  
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", DataSet Index:" + event.getDataSetIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
     public PieChartModel getPieModel() {
        return pieModel;
    }
 
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
 
   
}