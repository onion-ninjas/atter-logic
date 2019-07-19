import UIKit
import app

class ViewController: UIViewController {
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = "hej"
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
