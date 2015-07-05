import akka.actor.Actor
import akka.actor.Actor.Receive
import com.intellij.openapi.actionSystem.{AnActionEvent, AnAction}
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

/**
 * Created by bj on 05.07.15.
 */
case class TextBoxesInScala() extends AnAction("Text _Boxes in Scala") with Actor{
  override def actionPerformed(anActionEvent: AnActionEvent): Unit = {
    val project: Project = anActionEvent.getProject
    val txt: String = Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon)
    Messages.showMessageDialog(project, "Hello from Text Boxes in Scala, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon)
  }

  override def receive: Receive = {
    case _ => println("Hello from TextBoxesInScala Akka Actor")
  }
}
