class Calculate
  def initialize(file)
    @dept = 1
    @sum = 0
    @lines = 0
    rasa = calculate(file)
    puts "#{file}: lines #{@lines}, RaSa: #{rasa}"
  end

  def calculate(file)
    File.open(file, "r") do |infile|
      while (line = infile.gets)
        @lines += 1
        line.each_char do |sym|
          @dept += 1 if(sym == '{')
          @dept -= 1 if(sym == '}')
          @sum = @sum + @dept * 1 if (sym == ';')
        end
      end
      @sum
    end
  end
end

ARGV.each do |f|
  Calculate.new(f)
end
