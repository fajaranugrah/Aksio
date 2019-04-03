package com.example.fajar.aksio1;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 * Created by fajar on 17/04/2016.
 */
public class nilai_idn extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nilai_idn);
        OpenChart();
    }
    private GraphicalView mChart;

    private void OpenChart()
    {
        //Definisikan nilai-nilai yang ingin
        //divisualisasikan ke dalam chart
        int x[]={80,65,67,69};


        // Create XY Series for X Series.
        XYSeries xSeries=new XYSeries("X Series");


        //  Adding data to the X Series.
        for(int i=0;i<x.length;i++)
        {
            xSeries.add(i,x[i]);
        }

        // Create a Dataset to hold the XSeries.

        XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();

        // Add X series to the Dataset.
        dataset.addSeries(xSeries);


        // Create XYSeriesRenderer to customize XSeries

        XYSeriesRenderer Xrenderer=new XYSeriesRenderer();
        Xrenderer.setColor(Color.GREEN);
        Xrenderer.setPointStyle(PointStyle.DIAMOND);
        Xrenderer.setDisplayChartValues(true);
        Xrenderer.setLineWidth(2);
        Xrenderer.setFillPoints(true);


        // Create XYMultipleSeriesRenderer to customize the whole chart

        final XYMultipleSeriesRenderer mRenderer=new XYMultipleSeriesRenderer();

        mRenderer.setChartTitle("Peningkatan Nilai di Setiap Semester");
        mRenderer.setXTitle("X Values");
        mRenderer.setYTitle("Y Values");

        //Tambahkan tombol Zoom
        mRenderer.setZoomButtonsVisible(true);

        //Kita set 0 agar kita bisa membuat label kita sendiri
        mRenderer.setXLabels(0);

        //Agar chart bisa kita geser, kita aktifkan pan
        mRenderer.setPanEnabled(true);

        //Jika kita ingin membatasi user menggeser dari koodinat mana sampai mana,
        //kita set panlimit(xMinPanCoor, xMaxPanCoor, yMinPanCoor, yMaxPanCoor)
        mRenderer.setPanLimits(new double[] {0,100,-100,100});

        //Agar chart bisa kita zoom, kita aktifkan zoom
        mRenderer.setZoomEnabled(true);

        //Kita set biar ada grid yang tampak
        mRenderer.setShowGrid(true);

        //Set warna chart, label, axis
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.WHITE);
        mRenderer.setMarginsColor(Color.WHITE);
        mRenderer.setAxesColor(Color.BLACK);
        mRenderer.setLabelsColor(Color.BLACK);
        mRenderer.setXLabelsColor(Color.BLACK);
        mRenderer.setYLabelsColor(0, Color.BLACK);

        mRenderer.setXLabelsAlign(Paint.Align.CENTER);

        mRenderer.setClickEnabled(true);

        //Jika kita ingin label hanya ada pada range/nilai tertentu
        //Disini saya set label hanya ada setiap tiga nilai value dalam chart
        for(int i=0;i<x.length;i++)
        {
            if (i%1 == 0)
            {
                mRenderer.addXTextLabel(i, "Semester"); //label bisa angka, bisa text juga
            }
        }

        // Adding the XSeriesRenderer to the MultipleRenderer.
        mRenderer.addSeriesRenderer(Xrenderer);


        LinearLayout chart_container=(LinearLayout)findViewById(R.id.layout);

        // Creating an intent to plot line chart using dataset and muipleRenderer

        mChart=(GraphicalView) ChartFactory.getLineChartView(getBaseContext(), dataset, mRenderer);
        mChart.setBackgroundColor(Color.WHITE);

        //Di sini kita buat jika user mengklik suatu nilai values dalam chart,
        //akan nampil Toast nilai yang diklik user

        mChart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                SeriesSelection series_selection=mChart.getCurrentSeriesAndPoint();

                if(series_selection!=null)
                {
                    int series_index=series_selection.getSeriesIndex();

                    String select_series="X Series";
                    if(series_index==0)
                    {
                        select_series="X Series";
                    }else
                    {
                        select_series="Y Series";
                    }

                    //String month=mMonth[(int)series_selection.getXValue()];

                    int amount=(int)series_selection.getValue();

                    Toast.makeText(getBaseContext(), select_series + "in: " + amount, Toast.LENGTH_LONG).show();
                }
            }
        });


        // Masukkan chart ke dalam linear layout yang sudah dibuat
        chart_container.addView(mChart);


    }
}
