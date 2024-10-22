import { Input } from "@/components/ui/input"

export default function ElevatedInput() {
  return (
    <div className="w-full max-w-sm mx-auto">
      <div className="relative">
        <Input 
          type="text" 
          placeholder="Add Username" 
          className="w-full px-4 py-2 text-sm border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 transition-shadow duration-200 ease-in-out shadow-sm hover:shadow-md"
        />
      </div>
    </div>
  )
}