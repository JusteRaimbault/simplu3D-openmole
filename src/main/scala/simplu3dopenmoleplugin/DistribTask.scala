package simplu3dopenmoleplugin

import java.io.File
import fr.ign.simplu3d._

object DistribTask {
  def apply(folderIn: File, dirName: String, folderOut: File, paramFile: File, seed: Long): (String, File) = {
    val res = EPFIFTaskRunner.run(folderIn, dirName, folderOut, paramFile, seed);
    (res, folderOut)
  }

}

