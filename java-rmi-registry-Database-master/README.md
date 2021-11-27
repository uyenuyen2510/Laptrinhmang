# java-rmi-registry-Database
Explain the various methods of registering and gaining access to the Remote Object.
The methods of remote objects are to be invoked by implementing the java.rmi.Remote interface.

Methods of Remote Object

bind():
- Binds the specified name to the remote object.
- The name parameter of this method should be in an URL format.

unbind():
- Destroys the binding for a specific name of a remote method in the registry.

rebind():
- Binds again the specified name to the remote object.
- The current binding will be replaced by rebinding.

list():
- Returns the names of the names that were bound to the registry in an array form.
- These names are in the form of URL-formatted string.

lookup():
- A stub, a reference will be returned for the remote object which is related with a specified name.
Explain the steps to create RMI-based clients and server.
Creation of RMI-based Server:
- Create the Servant interface and the Servant component class.
- To host these servant classes create the RMI Server.
- Compile the class files and generate the Skeletons and IDL File.
- Start up the Server.

Creation of RMI-based Client:
- Create the Client class.
- Copy the IIOP Stubs and compile the Client.
- Make sure the Server is running and then startup the Client.
What are Remote callbacks?
In client-server technology / architecture, a server responds to a remote client. A call back is a method invocation from one application (Application A) from another application (Application B), as a result of action that was performed by the Application B earlier. The Application A may run on a client and the Application may run on a server. To perform the call back mechanism the system that Application A runs acts as a Server and that of the Application B runs acts as a client.
What is Object Activation?
Object Activation is a process of providing persistent references to the objects. It also includes the managing the execution of implementing of objects. RMI activates the objects for the execution as and when needed. The appropriate execution is initiated inside the appropriate JVM when the activatable remote object is accessed which is not currently running.

Discuss data transfer in RMI model.
- Data in a file can be transferred by using the method getFileContents(filename) in the remote interface.
- RMI supports to transfer data that is available in JDOM data objects.
What is object serialization in RMI?
- To marshal and unmarshall the parameters involves the object serialization and does not truncate types.

- The methods of local object and their bytecodes are not passed directly in the ObjectOutputStream. At times the name of the class of the objects may be needed that is to be loaded by the receiver if at all the class is not available locally. Just like the names of the classes, the class files themselves will not be serialized. All classes must load during the process of deserialization using the normal mechanisms of class loading.
What is RMI callback mechanism?
When one service passes an object which is the proxy for another service, the RMI callback mechanism occurs. The methods will be invoked by the recipient in the object it received and be calling back to the calling point. The stub contains the information that is needed to call back to server at the time of the need.

What is the role of Remote Interface in RMI?
Remote interfaces are defined by extending ,an interface called Remote provided in the java.rmi package. The methods must throw RemoteException. But application specific exceptions may also be thrown.

Explain marshalling and demarshalling.
During communication between two machines through RPC or RMI, parameters are packed into a message and then sent over the network. This packing of parameters into a message is called marshalling. On the other side these packed parameters are unpacked from the message which is called unmarshalling.
What is Object Activation?
Object Activation is a process of providing persistent references to the objects. It also includes the managing the execution of implementing of objects. RMI activates the objects for the execution as and when needed. The appropriate execution is initiated inside the appropriate JVM when the activatable remote object is accessed which is not currently running.

What is a skeleton in RMI?
Server side stub is refered to as a skeleton.
Explain the role of stub in RMI
The role of the stubs is to marshal and unmarshal the messages that are sent and received on the client or the server side.
Describe how the RMI mechanism works.
RMI is a mechanism that is to communicate between two Java Virtual Machines. This just does like invoking a method from local machine. The whole communication is called RMI mechanism.

RMI mechanism:
- To communicate between two remote methods by two different JVMs, there is always two intermediatory objects called stub and skeleton.
- The tasks that are performed by these two objects are as follows:

1. The tasks of stub object (on machine A)

A. Building a block of information which consists of:
- A remote object identifier that is to be used.
- The method describing operation number is to be called.
- The method parameters called marshaled parameters which are encoded into a specific format that is apt for transporting on the network.

B. Sending the above information to the server.

2. The tasks of skeleton object ( on the machine B):

- Unmarshalling the parameters.
- Invoking the real object’s required method which is on the server.
- Capturing the value returned or exception returned by the invoked call on the server.
- Marshaling this value.
- Sending the package along with the value in the form of marshaled back to the stub on the client on the machine A.
- The return value or exception from the server is unmarshalled by the stub and becomes the return value of the RMI. If the exception is thrown by the remote method then the stub object rethrows to the caller.
What are the layers on which RMI implementation is built? Explain them.
The Stub/Skeleton Layer:

- The stub/skeleton layer sits in between application layer and the rest of the RMI system and acts as an interface.
- This layer transmits the information to remote layer. This transmission is done through the marshalling of streams.
- These streams performs the object serialization.
- A stub is a remote object at the client-side. This stub implements all the interfaces which remote object implementation supports.
- A skeleton is a remote object at the server-side. This stub consists of methods that invokes dispatch calls to the remote implementation of objects.

The Remote Reference Layer:
- The lower level transport interfaces is dealt by this layer.
- This layer carries a specific remote reference protocol independent of stub and skeletons.
- Every remote object is implemented by choosing their individual remote reference subclasses.

The Transport Layer:
- The transport layer sets up the connections to remote address spaces, manages them, monitors the connection liveliness, and listens the incoming calls.
- The transport layer maintains the remote object’s table available in the address space, in a table. For incoming calls, the transport layer establishes a connection.
- It locates the target dispatcher of the remote calls and passes the connection to the dispatcher.

What are the layers of RMI Architecture?
- The three layers are the Stub and Skeleton Layer, the Remote Reference Layer, and the Transport Layer.
- The stub and skeleton layer is responsible for marshaling and unmarshaling the data and transmitting and receiving them to/from the Remote Reference Layer.
- The Remote reference layer is responsible for carrying out the invocation.
- The Transport layer is responsible for setting up connections, managing requests, monitoring them and listening for incoming calls.

Explain the diffference between RMI registry and OSAgent.
- RMI registry is the binder for Java RMI.
- An instance of RMI registry must run on every server computer that hosts remote objects.
- It maintains table mapping textual, URL style names to refer remote objects hosted on that computer.
- Naming class provides methods for RMI registry :
rebind(String name, Remote object)
bind(String name, Remote object)
unbind(String name, Remote object)
- The OSagent is a process that allows CORBA servers to register their objects and assists client applications in the location of objects.
- The OSagent is designed to be operated on more than one node.This is done to avoid a single point of failure.
- The OSagent processes follow a set of rules to discover each other and cooperate in the location of registered objects.

Explain how RMI clients contact remote RMI servers.
- The client procedure calls the client stub in the normal way.
- The client stub builds a message and traps to the kernel.
- The kernel sends the message to the remote kernel.
- The remote kernel gives the message to the server stub
- The server stub unpacks the parameters and calls the server.
- The server does the work and returns the result to the stub.
- The server stub packs it in a message and traps to the kernel.
- The remote kernel sends the message to the clients kernel.
- The clients kernel gives the message to the client stub.
- The stub unpacks the result and returns to the client.
What are the basic steps to write client-service application using RMI?
- Assigning the security manager and then obtaining the reference to the service.
- Contacting the RMI registry to obtain the remote object’s reference and invoking its methods.
- Requesting the name for the service.
- Invoke the remote method.

What is Unicast and Multicast object?
- The difference between unicast and multicast is that in unicast approach the sender sends the data stream to a single receiver at a time. Thus there is one to one communication.
- In a multicast the sender and the interested receivers communicate. This is one to many communication. This communication can take place between data terminals spread across various LANs too.
