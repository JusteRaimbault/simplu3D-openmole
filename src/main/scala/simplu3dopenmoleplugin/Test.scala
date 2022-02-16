package simplu3dopenmoleplugin

import java.io.File

object Test extends App {


  def runDistribTask(): Unit = {
    val (res, folderOut) = DistribTask.apply(folderIn = new File("src/main/resources/data"), dirName ="0",
      folderOut = new File("res"),
      paramFile = new File("src/main/resources/scenario/parameters_iau_idf.xml"), seed = 42L)
  }

  def runSimplu3dTask(): Unit = {
    val res = Simplu3DTask.apply(new File("src/main/resources/data"), outputFolder = new File("res"),
      paramFile = new File("src/main/resources/scenario/building_parameters_project_expthese_temp.xml"),
      distReculVoirie = 1.0, distReculFond = 1.0, distReculLat = 1.0, maximalCES = 0.5,
      hIniRoad = 5.0, slopeRoad = 1.5, hauteurMax = 20.0, seed = 42L
    )
  }

  runSimplu3dTask()

}
