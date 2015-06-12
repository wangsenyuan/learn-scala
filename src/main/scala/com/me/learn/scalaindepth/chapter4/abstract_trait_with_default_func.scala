package com.me.learn.scalaindepth.chapter4

/**
 * Created by senyuanwang on 15/6/12.
 */
object abstract_trait_with_default_func extends App {

  //  type SimulationMessage = String

  //  type SimulationContext = Map[String, Any]
  trait SimulationMessage

  class Request extends SimulationMessage

  class Response

  case class PingRequest(ip: String, sender: String) extends Request

  case class PingResponse(sender: String, addr: String) extends Response

  trait SimulationContext {
    def response[T <: Response](resp: T): Unit = {

    }
  }

  trait SimulationEntity {
    def handleMessage(msg: SimulationMessage, ctx: SimulationContext): Unit
  }

  trait NetworkEntityWithSelfRef {
    self: SimulationEntity =>
    def getMacAddress(ip: String): String

    def hasIpAddress(addr: String): Boolean

    def handleMessage(msg: SimulationMessage, ctx: SimulationContext): Unit = msg match {
      case PingRequest(ip, sender) => ctx response PingResponse(sender, getMacAddress(ip))
      case _ => self.handleMessage(msg, ctx)
    }
  }

  trait MixableParent extends SimulationEntity {
    override def handleMessage(msg: SimulationMessage, ctx: SimulationContext): Unit = {
      println("MixableParent::handleMessage()")
    }
  }

  trait NetworkEntityMixable extends MixableParent {
    def getMacAddress(ip: String): String = ""

    def hasIpAddress(addr: String): Boolean = false

    override def handleMessage(msg: SimulationMessage, ctx: SimulationContext): Unit = msg match {
      case PingRequest(ip, sender) => ctx response PingResponse(sender, getMacAddress(ip))
      case _ =>
        println("NetworkEntityMixable::handleMessage()")
        super.handleMessage(msg, ctx)
    }
  }

  case class Test(x: String) extends SimulationMessage

  trait Router extends SimulationEntity {
/*    override def getMacAddress(ip: String): String = "localhost"

    override def hasIpAddress(addr: String): Boolean = addr match {
      case "localhost" => true
      case _ => false
    }*/

    override def handleMessage(msg: SimulationMessage, ctx: SimulationContext): Unit = msg match {
      case Test(x) => println("YAH! " + x)
      case _ =>
    }

  }

  val mockCtx = new SimulationContext {}

  val router = new Router with NetworkEntityMixable

  router.handleMessage(Test("xxxx"), mockCtx)


  val router1 = new MixableParent with Router with NetworkEntityMixable

  router1.handleMessage(Test("xxxx"), mockCtx)
}
