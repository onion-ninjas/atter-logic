import UIKit
import app

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = Proxy().proxyHello()
        let dupa = BallisticCalculator()
        let dupa2 = dupa.getResult()
        
        let generyk = dupa.getCompany()
        let prawdziwygeneryk: Company = generyk.cycki
        
        switch prawdziwygeneryk {
        case is Company.Angrynerds:
            print(dupa)
        case is Company.Canva:
            print(dupa)
        case is Company.Tooploox:
            print(dupa)
        }
        
        let canva = dupa.getCanva()
        
        let czytuenum: ZwyklyProstyEnum = canva.ktury
        
        
        
        label.text = BallisticCalculator().getResult()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
